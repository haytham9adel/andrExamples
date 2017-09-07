package com.example.andr.andr_example.application;

import com.example.andr.andr_example.DrawerActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dev-haytham on 9/7/2017.
 */

@Singleton
@Component(modules={UseCaseModule.class})
public interface UseCaseComponent {
    void inject(DrawerActivity activity);
}
