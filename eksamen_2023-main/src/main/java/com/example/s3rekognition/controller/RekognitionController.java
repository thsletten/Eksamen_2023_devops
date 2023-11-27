package com.example.s3rekognition.controller;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.s3rekognition.PPEClassificationResponse;
import com.example.s3rekognition.PPEResponse;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class RekognitionController implements ApplicationListener<ApplicationReadyEvent> {

    private final AmazonS3 s3Client;
    private final AmazonRekognition rekognitionClient;
    private final MeterRegistry meterRegistry;

    private static final Logger logger = Logger.getLogger(RekognitionController.class.getName());

    @Autowired
    public RekognitionController(MeterRegistry meterRegistry) {
        this.s3Client = AmazonS3ClientBuilder.standard().build();
        this.rekognitionClient = AmazonRekognitionClientBuilder.standard().build();
        this.meterRegistry = meterRegistry;
    }

    @GetMapping(value = "/scan-ppe", consumes = "*/*", produces = "application/json")
    @ResponseBody
    public ResponseEntity<PPEResponse> scanForPPE(@RequestParam String bucketName) {
        Timer.Sample sample = Timer.start(meterRegistry);

        ListObjectsV2Result imageList = s3Client.listObjectsV2(bucketName);
        List<PPEClassificationResponse> classificationResponses = new ArrayList<>();
        List<S3ObjectSummary> images = imageList.getObjectSummaries();

        DistributionSummary summary = DistributionSummary
            .builder("rekognition.image.count")
            .description("Antall bilder skannet for PPE")
            .register(meterRegistry);

        summary.record(images.size());

        for (S3ObjectSummary image : images) {
            // ... Resten av koden ...
        }

        sample.stop(meterRegistry.timer("rekognition.scan.time", "bucket", bucketName));

        PPEResponse ppeResponse = new PPEResponse(bucketName, classificationResponses);
        return ResponseEntity.ok(ppeResponse);
    }

    // Resten av klassen ...

}

