package arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "cca.dsoo.ufscar.cms")
public class NomeclaturaTest {

    @ArchTest
    public static final ArchRule controllerNomenclatura = ArchRuleDefinition.classes().that()
            .areAnnotatedWith(RestController.class).or().haveNameMatching(".*Controller.*")
            .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    public static final ArchRule modelNomenclatura = ArchRuleDefinition.classes().that()
            .resideInAPackage("..model..").should().haveSimpleNameEndingWith("Model")
        .orShould().haveNameMatching(".*Model.*");

    @ArchTest
    public static final ArchRule viewNomenclatura = ArchRuleDefinition.classes().that()
            .resideInAPackage("..view..").should().haveNameMatching(".*View.*");

}
