package name.webdizz.sonar.grammar;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;
import name.webdizz.sonar.grammar.profile.ProfileModifier;
import name.webdizz.sonar.grammar.rule.GrammarRuleRepository;
import name.webdizz.sonar.grammar.sensor.GrammarSensor;
import name.webdizz.sonar.grammar.spellcheck.SourceGrammarAnalyser;

@Properties({
        @Property(
                key = GrammarPlugin.EXCLUSION,
                name = "Exclusion Property",
                description = "Defines resources to be excluded from analysis",
                defaultValue = ""),
        @Property(
                key = GrammarPlugin.INCLUSION,
                name = "Inclusion Property",
                description = "Defines resources to be included for analysis",
                defaultValue = ""),
        @Property(
                key = GrammarPlugin.DICTIONARY,
                name = "Dictionary path",
                description = "Defines resources to be included for analysis",
                defaultValue = "dict/english.0")})
public class GrammarPlugin extends SonarPlugin {

    public static final String EXCLUSION = "sonar.grammar.exclusion";
    public static final String INCLUSION = "sonar.grammar.inclusion";
    public static final String DICTIONARY = "sonar.grammar.dictionary";
    public static final String PLUGIN_NAME = "Sonar Grammar";

    @Override
    public List getExtensions() {
        return Arrays
                .asList(
                // Definitions
                GrammarMetrics.class,
                GrammarRuleRepository.class,
                SourceGrammarAnalyser.class,
                ProfileModifier.class,
                // Batch
                GrammarSensor.class);
    }
}
