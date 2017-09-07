package com.example.andr.andr_example.application;


/**
 * Created by dev-haytham on 9/7/2017.
 */

public class ApplicationComponentImpl implements ApplicationComponent {

    private NetComponent mNetComponent;
    private UseCaseComponent mUseCaseComponent;

    private static ApplicationComponentImpl _ApplicationComponents ;

    public static ApplicationComponentImpl getInstance() {
        if( _ApplicationComponents == null) {
            _ApplicationComponents = new ApplicationComponentImpl() ;
        }
        return _ApplicationComponents ;
    }

    private ApplicationComponentImpl() {

        // Dagger%COMPONENT_NAME%
        mUseCaseComponent = DaggerUseCaseComponent.create() ;

        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .netModule(new NetModule("https://api.github.com"))
                .build();

    }

    //dagger
    public UseCaseComponent getUseCaseComponent() {
        return mUseCaseComponent;
    }
    //dagger
    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
