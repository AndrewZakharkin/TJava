open module MainMod{
    exports com.zakharkin.Main;
    requires java.management;
    requires jdk.attach;
    requires org.apache.commons.lang3;
}