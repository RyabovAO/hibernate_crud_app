package com.aleksey.crud_app.controller;

import com.aleksey.crud_app.model.Writer;
import com.aleksey.crud_app.services.WriterService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WriterController {
    private final WriterService writerService;

    public WriterController() {
        this.writerService = new WriterService();
    }

    public Writer createWriter (String fistName, String lastName) {
        Writer writer = new Writer();
        writer.setFistName(fistName);
        writer.setLastName(lastName);
        return writerService.createWriter(writer);
    }

    public Writer updateWriter(Long id, String fistName, String lastName) {
        Writer writer = new Writer();
        writer.setId(id);
        writer.setFistName(fistName);
        writer.setLastName(lastName);
        return writerService.updateWriter(writer);
    }

    public Writer getWriterById(Long id) {
        return writerService.getWriterById(id);
    }

    public List<Writer> getAllWriters() {
        return writerService.getAllWriters();
    }

    public void deleteWriterById(Long id) {
        writerService.deleteWriterById(id);
    }
}
