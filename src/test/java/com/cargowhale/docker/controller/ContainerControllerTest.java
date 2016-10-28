package com.cargowhale.docker.controller;

import com.cargowhale.docker.client.ContainerClient;
import com.cargowhale.docker.container.ContainerInfoCollectionVM;
import com.cargowhale.docker.domain.ChangeStatusRequest;
import com.cargowhale.docker.domain.ChangeStatusResponse;
import com.cargowhale.docker.service.ContainerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContainerControllerTest {

    @InjectMocks
    private ContainerController controller;

    @Mock
    private ContainerClient client;

    @Mock
    private ContainerService service;

    @Test
    public void getAllContainersReturnsEveryContainerFromService() {
        ContainerInfoCollectionVM containerInfoCollectionVM = mock(ContainerInfoCollectionVM.class);

        when(this.service.getAllContainers()).thenReturn(containerInfoCollectionVM);

        assertThat(this.controller.getAllContainers(), is(containerInfoCollectionVM));
    }

    @Test
    public void getFilteredContainersReturnsFilteredContainersFromService() {
        String expected = "ALL RUNNING CATALOGS";
        String filter = "running";

        when(this.service.getFilteredContainers(filter)).thenReturn(expected);

        assertThat(this.controller.getFilteredContainers(filter), is(expected));
    }

    @Test
    public void setContainerStatusSetsContainerToRunning(){
        String status = "running";
        String name = "testName";
        ChangeStatusResponse expected = new ChangeStatusResponse("returnName");

        ChangeStatusRequest statusRequest = new ChangeStatusRequest(status);

        when(this.service.setContainerStatus(name, statusRequest)).thenReturn(expected);

        assertThat(this.controller.setContainerStatus(name, statusRequest), is(expected));
    }
}
