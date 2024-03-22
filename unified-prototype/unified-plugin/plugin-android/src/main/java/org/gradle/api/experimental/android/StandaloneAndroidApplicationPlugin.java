package org.gradle.api.experimental.android;

import org.gradle.api.*;

/**
 * Creates a declarative {@link StandaloneAndroidApplication} DSL model, applies the official Android plugin,
 * and links the declarative model to the official plugin.
 */
public abstract class StandaloneAndroidApplicationPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        StandaloneAndroidApplication dslModel = createDslModel(project);

        // Register an afterEvaluate listener before we apply the Android plugin to ensure we can
        // run actions before Android does.
        project.afterEvaluate(p -> AndroidDSLSupport.linkDslModelToPlugin(p, dslModel));

        // Apply the official Android plugin.
        project.getPlugins().apply("com.android.application");
        project.getPlugins().apply("org.jetbrains.kotlin.android");

        AndroidDeclarativeDependencies dslDependencies = project.getExtensions().create("declarativeDependencies", AndroidDeclarativeDependencies.class);

        AndroidDSLSupport.linkDslModelToPluginLazy(project, dslDependencies);
    }



    private StandaloneAndroidApplication createDslModel(Project project) {
       // AndroidTarget dslDebug = project.getObjects().newInstance(AndroidTarget.class, "debug");
       // AndroidTarget dslRelease = project.getObjects().newInstance(AndroidTarget.class, "release");
        return project.getExtensions().create("androidApplication", StandaloneAndroidApplication.class);
    }
}
