package br.com.sistemas.magna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemas.magna.dto.TimeDTO;
import br.com.sistemas.magna.service.TimeService;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<TimeDTO> getAllTimes() {
        return timeService.getAllTimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeDTO> getTimeById(@PathVariable Long id) {
        Optional<TimeDTO> time = timeService.getTimeById(id);
        return time.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TimeDTO> createTime(@RequestBody TimeDTO timeDTO) {
        TimeDTO createdTime = timeService.createTime(timeDTO);
        return new ResponseEntity<>(createdTime, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeDTO> updateTime(@PathVariable Long id, @RequestBody TimeDTO timeDetailsDTO) {
        Optional<TimeDTO> updatedTime = timeService.updateTime(id, timeDetailsDTO);
        return updatedTime.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long id) {
        timeService.deleteTime(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
