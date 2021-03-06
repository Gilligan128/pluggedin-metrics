import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {CommonModule} from "@angular/common";
import {CardComponent} from "./card/card.component";
import {MainComponent} from "./main/main.component";
import {DividerComponent} from "./divider/divider.component";
import {PipesModule} from "../pipes";
import {MetricsService} from "./main/services/metrics.service";
import {ApiService} from "./main/services/api.service";

const DECLARED_COMPONENTS = [
    CardComponent,
    MainComponent,
    DividerComponent
];

const EXPORTED_COMPONENTS = [
    CardComponent,
    MainComponent,
    DividerComponent
];

@NgModule({
    imports: [
        CommonModule,
        PipesModule
    ],
    declarations: [
        ...DECLARED_COMPONENTS
    ],
    exports: [
        ...EXPORTED_COMPONENTS
    ],
    providers: [
        ApiService,
        MetricsService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LayoutsModule {
}