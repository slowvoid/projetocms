package arch;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaPackage;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.metrics.ArchitectureMetrics;
import com.tngtech.archunit.library.metrics.ComponentDependencyMetrics;
import com.tngtech.archunit.library.metrics.MetricsComponents;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class
DependencyMetricsTest {
    final Set<JavaPackage> packages = new ClassFileImporter()
            .importPackages("cca.dsoo.ufscar.cms").getPackage("cca.dsoo.ufscar.cms").getSubpackages();

    //Métricas de dependência cumulativa por John Lakos
    //Obs.: Visão de todos os componentes mas possibilidade por componente
    @Test
    void cumulativeDependencyMetrics() {
        final var components = MetricsComponents.fromPackages(packages);
        final var metrics = ArchitectureMetrics.lakosMetrics(components);

        System.out.println("Cumulative Component Dependency(CCD): " + metrics.getCumulativeComponentDependency());
        System.out.println("Average Component Dependency(ACD): " + metrics.getAverageComponentDependency());
        System.out.println("Relative Average Component Dependency(RACD): " + metrics.getRelativeAverageComponentDependency());
        System.out.println("Normalized Cumulative Component Dependency(NCCD): " + metrics.getNormalizedCumulativeComponentDependency());
    }

    //Métricas de dependência de componentes por Robert C. Martin
    //Obs.: Visão por pacote, no caso a Controller
    @Test
    void componentDependencyMetrics() {
        final var componentIdentifier = "cca.dsoo.ufscar.cms.controller";

        MetricsComponents<JavaClass> components = MetricsComponents.fromPackages(packages);
       ComponentDependencyMetrics metrics = ArchitectureMetrics.componentDependencyMetrics(components);

        System.out.println("Efferent Coupling(Ce): " + metrics.getEfferentCoupling(componentIdentifier));
        System.out.println("Afferent coupling(Ca): " + metrics.getAfferentCoupling(componentIdentifier));
        System.out.println("Instability(I): " + metrics.getInstability(componentIdentifier));
        System.out.println("Abstractness(A): " + metrics.getAbstractness(componentIdentifier));
        System.out.println("Normalized distance from main sequence(D): " + metrics.getNormalizedDistanceFromMainSequence(componentIdentifier));
    }

    //Métricas de Visibilidade por Herbert Dowalil
    //Obs.: Visão por pacote, no caso a Controller
    @Test
    void visibilityMetrics() {
        final var components = MetricsComponents.fromPackages(packages);
        final var metrics = ArchitectureMetrics.visibilityMetrics(components);
        final var componentIdentifier = "cca.dsoo.ufscar.cms.controller";

        System.out.println("Relative Visibility(RV): " + metrics.getRelativeVisibility(componentIdentifier));
        System.out.println("Average Relative Visibility(VRM): " + metrics.getAverageRelativeVisibility());
        System.out.println("Global Relative Visibility(GRV): " + metrics.getGlobalRelativeVisibility());
    }

}
