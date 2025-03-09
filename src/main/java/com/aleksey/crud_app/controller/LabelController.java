package com.aleksey.crud_app.controller;

import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.repository.LabelRepository;
import com.aleksey.crud_app.repository.jdbc.LabelRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController() {
        this.labelRepository = new LabelRepositoryImpl();
    }

        public Label createLabel(String name) {
        if(name == null) {
            return null;
        }
        Label label = new Label();
        label.setName(name);
        return labelRepository.create(label);
    }

    public Label updateLabel(Long id, String newName) {
        if(id == 0 || newName == null) {
            return null;
        }
        Label label = new Label();
        label.setId(id);
        label.setName(newName);
        labelRepository.update(label);
        return label;
    }

    public List<Label> getAllLabel() {
        return labelRepository.getAll();
    }

    public Label getLabelById(long id) {
        if(id == 0) {
            System.out.println("Uncorrected id");
            return null;
        }
        return labelRepository.getById(id);
    }

    public void deleteLabelById(long id) {
        if(id == 0) {
            System.out.println("Uncorrected id");
        } else labelRepository.delete(id);

    }
}