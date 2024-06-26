package org.gradle.api.experimental.android;

import org.gradle.api.model.ObjectFactory;
import org.gradle.declarative.dsl.model.annotations.Restricted;

import javax.inject.Inject;

/**
 * The public DSL interface for a declarative Android library.
 */
@Restricted
public abstract class StandaloneAndroidApplication implements AndroidApplication {
    private final AndroidDeclarativeDependencies dependencies;
   // private final AndroidTargets targets;

    @Inject
    public StandaloneAndroidApplication(ObjectFactory objectFactory) {
        //this.targets = targets;
        this.dependencies = objectFactory.newInstance(AndroidDeclarativeDependencies.class);
    }

    /**
     * Static targets extension block.
     */
    //@Override
    //public AndroidTargets getTargets() {
        //return targets;
    //}

    /**
     * Common dependencies for all targets.
     */
    @Override
    public AndroidDeclarativeDependencies getDeclarativeDependencies() {
        return dependencies;
    }
}
