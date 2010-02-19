<html>
    <head>
        <title><g:layoutTitle default="Canonical" /></title>
        <canonical:show />
        <g:layoutHead />
    </head>
    <body>
        Canonical Tag: ${canonical.show().toString().encodeAsHTML()}
        <g:layoutBody />
    </body>
</html>