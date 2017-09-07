package com.example.andr.andr_example.application;

import android.app.Application;

import com.example.andr.andr_example.useCase.SomeUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dev-haytham on 9/7/2017.
 */

@Module
public class UseCaseModule {


    @Provides
    @Singleton
    SomeUseCase providesSomeUseCase() {
        return new SomeUseCase() ;
    }

}
