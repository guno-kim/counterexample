package project.counterexample.domain.entity;

import lombok.Getter;

@Getter
public enum Provider {
    GOOGLE("Google"),FACEBOOK("Facebook");

    private final String name;
    Provider(String provider) {
        this.name = provider;
    }

    static public Provider fromStr(String provider) {
        if(provider.equals("Google"))
            return GOOGLE;
        else
            return FACEBOOK;
    }
}