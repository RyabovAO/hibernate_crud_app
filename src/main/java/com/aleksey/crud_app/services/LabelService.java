package com.aleksey.crud_app.services;

import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.repository.LabelRepository;
import com.aleksey.crud_app.repository.jdbc.LabelRepositoryImpl;

import java.util.List;

public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService() {
        this.labelRepository = new LabelRepositoryImpl();
    }

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Label createLabel(Label label) {
        return labelRepository.create(label);
    }

    public Label updateLabel(Label label) {
        return labelRepository.update(label);
    }

    public List<Label> getAllLabel() {
        return labelRepository.getAll();
    }

    public Label getLabelById(long id) {
        return labelRepository.getById(id);
    }

    public void deleteLabelById(long id) {
        labelRepository.deleteById(id);
    }
}
