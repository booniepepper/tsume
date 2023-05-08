package so.dang.cool;

import rife.bld.BaseProject;

import java.util.List;

public class TsumeBuild extends BaseProject {
    public TsumeBuild() {
        pkg = "so.dang.cool";
        name = "Tsume";
        version = version(0,1,0);

        testOperation().mainClass("so.dang.cool.TsumeTest");
    }

    public static void main(String[] args) {
        new TsumeBuild().start(args);
    }
}