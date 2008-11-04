package javax.validation.bootstrap;

import javax.validation.ValidationProviderResolver;
import javax.validation.ValidatorFactoryBuilder;

/**
 * Build implementations of builderType, the specific ValidatorFactoryBuilder sub interface uniquely identifying
 * a provider.
 * <p/>
 * The requested provider is the first provider suitable for T (as defined in
 * {@link javax.validation.spi.ValidationProvider#isSuitable(Class)}). The list of providers evaluated is
 * returned by {@link ValidationProviderResolver}. If no ValidationProviderResolver is defined, the
 * default ValidationProviderResolver strategy is used.
 *
 * @author Emmanuel Bernard
 */
public interface SpecializedBuilderFactory<T extends ValidatorFactoryBuilder<T>> {

	/**
	 * Optionally define the provider resolver implementation used.
	 * If not defined, use the default ValidationProviderResolver
	 *
	 * @param resolver ValidationProviderResolver implementation used
	 *
	 * @return self
	 */
	public SpecializedBuilderFactory<T> providerResolver(ValidationProviderResolver resolver);

	/**
	 * Determine the provider implementation suitable for builderType and delegate the creation
	 * of this specific ValidatorFactoryBuilder subclass to the provider.
	 *
	 * @return a ValidatorFactoryBuilder sub interface implementation
	 */
	public T getBuilder();
}
