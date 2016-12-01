package com.cargowhale.docker.container.info;

import com.cargowhale.docker.container.LogFilters;
import com.cargowhale.docker.container.info.model.ContainerDetails;
import com.cargowhale.docker.container.info.model.ContainerLogs;
import com.cargowhale.docker.container.info.model.ContainerProcessIndex;
import com.cargowhale.docker.container.info.resource.*;
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
public class ContainerDetailsControllerTest {

    @InjectMocks
    private ContainerDetailsController controller;

    @Mock
    private ContainerInfoService service;

    @Mock
    private ContainerDetailsResourceAssembler detailsResourceAssembler;

    @Mock
    private ContainerLogsResourceAssembler logsResourceAssembler;

    @Mock
    private ContainerProcessesResourceAssembler processesResourceAssembler;

    @Test
    public void getContainerDetailsById() throws Exception {
        String containerId = "container id!";
        ContainerDetails containerDetails = mock(ContainerDetails.class);
        ContainerDetailsResource containerDetailsResource = mock(ContainerDetailsResource.class);

        when(this.service.getContainerDetailsById(containerId)).thenReturn(containerDetails);
        when(this.detailsResourceAssembler.toResource(containerDetails)).thenReturn(containerDetailsResource);

        assertThat(this.controller.getContainerById(containerId), is(containerDetailsResource));
    }

    @Test
    public void getContainerLogsById() {
        String containerId = "container id!";

        String follow = "0";
        String stdOut = "1";
        String stdErr = "0";
        String since = "0";
        String timestamps = "1";
        String tail = "1000";
        LogFilters logFilters = new LogFilters(follow, stdOut, stdErr, since, timestamps, tail);

        ContainerLogs containerLogs = mock(ContainerLogs.class);
        ContainerLogsResource containerLogsResource = mock(ContainerLogsResource.class);

        when(this.service.getContainerLogsById(containerId, logFilters)).thenReturn(containerLogs);
        when(this.logsResourceAssembler.toResource(containerLogs)).thenReturn(containerLogsResource);

        assertThat(this.controller.getContainerLogsById(containerId, logFilters), is(containerLogsResource));
    }

    @Test
    public void getContainerProcessesById(){
        String containerId = "container id!";
        ContainerProcessIndex processes = mock(ContainerProcessIndex.class);
        ContainerProcessesResource processesResource = mock(ContainerProcessesResource.class);

        when(this.service.getContainerProcessesById(containerId)).thenReturn(processes);
        when(this.processesResourceAssembler.toResource(processes)).thenReturn(processesResource);

        assertThat(this.controller.getContainerProcessesById(containerId), is(processesResource));


    }
}