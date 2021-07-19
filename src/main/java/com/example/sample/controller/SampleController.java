package com.example.sample.controller;

import com.example.sample.model.Record;
import com.example.sample.model.SampleRequest;
import com.example.sample.model.SampleResponse;
import com.example.sample.respository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final RecordRepository recordRepository;

    @GetMapping
    public ResponseEntity<SampleResponse> getSampleDataByIds(@RequestParam("ids") List<Long> ids) {
        SampleResponse sampleResponse = new SampleResponse();

        Iterable<Record> records = recordRepository.findAllById(ids);
        sampleResponse.setPayload(records);

        return new ResponseEntity(sampleResponse, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<SampleResponse> deleteSampleDataById(@RequestParam("id") Long id) {
        Optional<Record> recordOptional = recordRepository.findById(id);

        if(recordOptional.isPresent()) {
            recordRepository.delete(recordOptional.get());
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<SampleResponse> updateData(@RequestParam("id") Long id, @RequestBody SampleRequest sampleRequest) {
        Optional<Record> recordOptional = recordRepository.findById(id);

        if(recordOptional.isPresent()) {
            SampleResponse sampleResponse = new SampleResponse();

            Record record = recordOptional.get();
            record.setData(String.valueOf(sampleRequest.getPayload()));

            sampleResponse.setPayload(recordRepository.save(record));
            return new ResponseEntity(sampleResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SampleResponse> saveNewData(@RequestBody SampleRequest sampleRequest) {
        SampleResponse sampleResponse = new SampleResponse();

        Record record = new Record();
        record.setData(String.valueOf(sampleRequest.getPayload()));
        sampleResponse.setPayload(recordRepository.save(record));

        return new ResponseEntity(sampleResponse, HttpStatus.OK);
    }
}
