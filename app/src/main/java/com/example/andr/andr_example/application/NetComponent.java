package com.example.andr.andr_example.application;

import com.example.andr.andr_example.helpers.UIHelper;
import com.example.andr.andr_example.useCase.SomeUseCase;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dev-haytham on 9/7/2017.
 */

@Singleton
@Component(modules={ NetModule.class})
public interface NetComponent {
         void inject(SomeUseCase someUseCase);
}