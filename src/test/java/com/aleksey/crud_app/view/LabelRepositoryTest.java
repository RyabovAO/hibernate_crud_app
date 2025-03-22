package com.aleksey.crud_app.view;


import com.aleksey.crud_app.hibernate_running.HibernateUtil;
import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.repository.LabelRepository;
import com.aleksey.crud_app.services.LabelService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LabelRepositoryTest {

    @InjectMocks
    private LabelService labelService;

    @Mock
    private LabelRepository labelRepository;

    @Test
    void createLabelTest() {

        Label actulaLabel = Label.builder()
                .name("TestName")
                .build();

        Mockito.when(labelRepository.create(actulaLabel)).thenReturn(actulaLabel);

        Label expectedLabel = labelService.createLabel(actulaLabel);
        Assertions.assertEquals(actulaLabel, expectedLabel);
    }

    @Test
    void createLabelTestNameIsNull() {
        Label actualLabel = new Label();
        actualLabel.setName(null);

        Mockito.when(labelRepository.create(actualLabel)).thenReturn(null);

        Label expectedLabel;
        expectedLabel = labelService.createLabel(actualLabel);

        Assertions.assertNull(expectedLabel);
    }

    @Test
    void updateLabelTest() {
        Label label = new Label(2, "newTestName");

        Mockito.when(labelRepository.update(label)).thenReturn(label);

        Label labelForTest;

        labelForTest = labelService.updateLabel(label);

        Assertions.assertEquals(label, labelForTest);
    }

    @Test
    void getLabelTestCorrectedId() {
        Label label = new Label(1, "raskaz");

        Mockito.when(labelRepository.getById(1L)).thenReturn(label);

        Label testLabel;

        testLabel = labelService.getLabelById(1);

        Assertions.assertEquals(label, testLabel);
    }

    @Test
    void getLabelTestWhenIdIsZero() {

        Mockito.when(labelRepository.getById(0L)).thenReturn(null);

        Label testLabel;

        testLabel = labelService.getLabelById(0);

        Assertions.assertNull(testLabel);
    }

    @Test
    void getAllLabelTest() {

        Label label = new Label(1, "raskaz");
        Label label2 = new Label(2, "raskaz2");
        List<Label> expectedList = new ArrayList<>(Arrays.asList(label, label2));

        Mockito.when(labelRepository.getAll()).thenReturn(expectedList);

        List<Label> actualList;

        actualList = labelService.getAllLabel();

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void deleteLabelTestCorrectedId() {

        Mockito.doNothing().when(labelRepository).deleteById(1L);

        labelService.deleteLabelById(1);

        Mockito.verify(labelRepository).deleteById(1L);
    }

}
