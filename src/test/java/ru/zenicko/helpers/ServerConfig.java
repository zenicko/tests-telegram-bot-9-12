package ru.zenicko.helpers;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:ServerConfig.properties"})
public interface ServerConfig extends Config {
    String username();
    String password();
}
