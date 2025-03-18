package com.aleksey.crud_app.services;

import com.aleksey.crud_app.model.Writer;
import com.aleksey.crud_app.repository.WriterRepository;
import com.aleksey.crud_app.repository.jdbc.WriterRepositoryImpl;

import java.util.List;

public class WriterService {
    private WriterRepository writerRepository;

    public WriterService () {
        writerRepository = new WriterRepositoryImpl();
    }

    public Writer createWriter (Writer writer) {
        return writerRepository.create(writer);
    }

    public Writer updateWriter(Writer writer) {
        return writerRepository.update(writer);
    }

    public Writer getWriterById(Long id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public void deleteWriterById(Long id) {
        writerRepository.deleteById(id);
    }
}
