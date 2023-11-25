terraform {
  backend "s3" {
    bucket = "2032-terraform"
    key    = "terraform/state"
    region = "eu-west-1"
  }
}
