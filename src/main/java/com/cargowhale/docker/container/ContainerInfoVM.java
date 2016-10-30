package com.cargowhale.docker.container;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ContainerInfoVM {

    private final List<String> names;
    private final String image;
    private final ContainerState state;

    public ContainerInfoVM(@JsonProperty("Names") final List<String> names,
                           @JsonProperty("Image") final String image,
                           @JsonProperty("State") final ContainerState state) {
        this.names = names;
        this.image = image;
        this.state = state;
    }

    public List<String> getNames() {
        return this.names;
    }

    public String getImage() {
        return this.image;
    }

    public ContainerState getState() {
        return this.state;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ContainerInfoVM that = (ContainerInfoVM) o;

        if (names != null ? !names.equals(that.names) : that.names != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return this.state == that.state;
    }

    @Override
    public int hashCode() {
        int result = names != null ? names.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
