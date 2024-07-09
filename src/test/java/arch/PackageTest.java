package arch;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "cca.dsoo.ufscar.cms")
public class PackageTest {

    //ATRIBUTOS

    //Verificação do pacotes que podem acessar as classes
    @ArchTest
    public static final ArchRule viewAcesso = ArchRuleDefinition.classes()
            .that().resideInAPackage("..view..")
            .should().onlyBeAccessed().byAnyPackage("..view..","..util..","..controller..")
            .as("Classes no pacote 'view' só podem acessar classes nos pacotes 'view' e 'util'.");

    @ArchTest
    public static final ArchRule controllerAcesso = ArchRuleDefinition.classes()
            .that().resideInAPackage("..controller..")
            .should().onlyBeAccessed().byAnyPackage("..util..", "..controller..")
            .as("Classes no pacote 'controller' só podem acessar classes nos pacotes 'view', 'controller' e 'util'.");

    @ArchTest
    public static final ArchRule modelAcesso = ArchRuleDefinition.classes()
            .that().resideInAPackage("..model..")
            .should().onlyBeAccessed().byAnyPackage("..model..","..util..", "..data..")
            .as("Classes no pacote 'model' só podem acessar classes nos pacotes 'model', 'data' e 'util'.");

    @ArchTest
    public static final ArchRule dataAcesso = ArchRuleDefinition.classes()
            .that().resideInAPackage("..data..")
            .should().onlyBeAccessed().byAnyPackage("..util..","..data..")
            .as("Classes no pacote 'model' só podem acessar classes nos pacotes 'util'.");

    //Verificação se as classes com anotação ou nomes estão no pacote correto
    @ArchTest
    public final ArchRule controllerClasses = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(RestController.class).or().haveNameMatching(".*Controller.*")
            .should().resideInAPackage("..controller..")
            .as("Classes controller devem ficar no pacote controller");

    @ArchTest
    public final ArchRule modelClasses = ArchRuleDefinition.classes()
            .that().haveNameMatching(".*Model.*")
            .should().resideInAPackage("..model..")
            .as("Classes model devem ficar no pacote model");

    @ArchTest
    public final ArchRule viewClasses = ArchRuleDefinition.classes()
            .that().haveNameMatching(".*View.*")
            .should().resideInAPackage("..view..")
            .as("Classes view devem ficar no pacote view");
}