package com.aleksey.crud_app.view;


import com.aleksey.crud_app.controller.LabelController;
import com.aleksey.crud_app.repository.LabelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LabelControllerTest {

    @InjectMocks
    private LabelController labelController;
    @Mock
    private LabelRepository labelRepository;

    @Test
    void labelTest() {

}

}
