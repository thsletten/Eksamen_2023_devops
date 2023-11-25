variable "service_name" {
  description = "Navnet på tjenesten"
  type        = string
  default     = "2032-service"
}

variable "role_name" {
  description = "Navnet på IAM-rollen"
  type        = string
  default     = "2032-iam-role"
}

variable "policy_name" {
  description = "Navnet på IAM-policyen"
  type        = string
  default     = "2032-policy"
}

variable "ecr_repository" {
  description = "ECR-repositoriet for Docker-bildet"
  type        = string
  default     = "244530008913.dkr.ecr.eu-west-1.amazonaws.com/kand2032"
}

resource "aws_apprunner_service" "service" {
  service_name = var.service_name

  instance_configuration {
    instance_role_arn = aws_iam_role.role_for_apprunner_service.arn
    cpu               = "256"
    memory            = "1024"
  }

  source_configuration {
    authentication_configuration {
      access_role_arn = "arn:aws:iam::244530008913:role/service-role/AppRunnerECRAccessRole"
    }
    image_repository {
      image_configuration {
        port = "8080"
      }
      image_identifier      = "${var.ecr_repository}:latest"
      image_repository_type = "ECR"
    }
    auto_deployments_enabled = true
  }
}

resource "aws_iam_role" "role_for_apprunner_service" {
  name               = var.role_name
  assume_role_policy = data.aws_iam_policy_document.assume_role.json
}

data "aws_iam_policy_document" "assume_role" {
  statement {
    effect = "Allow"

    principals {
      type        = "Service"
      identifiers = ["tasks.apprunner.amazonaws.com"]
    }

    actions = ["sts:AssumeRole"]
  }
}

data "aws_iam_policy_document" "policy" {
  statement {
    effect    = "Allow"
    actions   = ["rekognition:*"]
    resources = ["*"]
  }
  
  statement  {
    effect    = "Allow"
    actions   = ["s3:*"]
    resources = ["*"]
  }

  statement  {
    effect    = "Allow"
    actions   = ["cloudwatch:*"]
    resources = ["*"]
  }
}

resource "aws_iam_policy" "policy" {
  name        = var.policy_name
  description = "Policy for apprunner instance I think"
  policy      = data.aws_iam_policy_document.policy.json
}

resource "aws_iam_role_policy_attachment" "attachment" {
  role       = aws_iam_role.role_for_apprunner_service.name
  policy_arn = aws_iam_policy.policy.arn
}

