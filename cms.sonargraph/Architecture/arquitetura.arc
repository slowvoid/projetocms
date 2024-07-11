// Press F1 to get detailed help about Sonargraph's architecture DSL.
//
// To enable architecture checking on this file please right click on it in
// the architecture view or files view and select 'Add to Architecture Check'.
//
// The allowed dependencies (connect statements) are based on your workspace
// dependencies which can be visualized by opening the workspace dependencies
// view. If you get "Missing workspace dependency" warnings in the issues view you
// will also get architecture violations. To remedy this problem you have to add
// the allowed connections to the artifacts causing the violations. The best way
// to inspect architecture violations is to use the architecture view and select the
// architecture file of interest. You can also add the missing workspace dependencies
// in the workspace dependencies view and then re-generate this architecture.
//
// You can now enhance this initial architecture by fleshing out the internal structure of
// your modules. Please make sure to read our documentation about the architecture DSL (F1) so
// that you get a better idea how you can create a concise and elegant architectural blueprint
// for your application.

model "physical"

artifact controller
{
    include "**/controller/**"
    
    connect to model
    connect to view.factory, view.viewInterfaces
}

artifact model
{
    include "**/model/**"
    
    connect to data
}

artifact data
{
    include "**/data/**"
}

artifact view
{
    local artifact concreteViews
    {
        include "**/view/*View" and not "**/view/ViewFactory"
        
        interface viewInterface
        {
            include "**/IView"
        }
        
        connect to util
    }
    
    exposed artifact factory
    {
        include "**/view/ViewFactory"
        
        connect to concreteViews
    }
    
    interface viewInterfaces
    {
        export concreteViews.viewInterface
    }
}

public artifact util
{
    include "**/util/**"
}

artifact app
{
    include "main/cca/dsoo/ufscar/cms/CmsApplication"
}
