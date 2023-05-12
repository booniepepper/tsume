package so.dang.cool;

import java.util.List;
import rife.bld.BaseProject;
import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.*;

public class TsumeBuild extends BaseProject {
    public TsumeBuild() {
        pkg = "so.dang.cool";
        name = "Tsume";
        version = version(0,1,0);

        repositories = List.of(MAVEN_CENTRAL);

        scope(test)
            .include(dependency("org.junit.jupiter", "junit-jupiter", "5.9.3"))
            .include(dependency("org.junit.platform", "junit-platform-console-standalone", "1.9.3"));
    }

    public static void main(String[] args) {
        new TsumeBuild().start(args);
    }
}
