package project.counterexample.domain.type;

import lombok.Getter;

@Getter
public enum ProviderType {
    GOOGLE("Google"),FACEBOOK("Facebook");

    private final String name;
    ProviderType(String provider) {
        this.name = provider;
    }

    static public ProviderType fromStr(String provider) {
        if(provider.equals("Google"))
            return GOOGLE;
        else
            return FACEBOOK;
    }
}