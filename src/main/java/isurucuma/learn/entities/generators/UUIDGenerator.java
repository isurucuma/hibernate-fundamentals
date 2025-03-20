package isurucuma.learn.entities.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.spi.StandardGenerator;

import java.util.EnumSet;
import java.util.UUID;

public class UUIDGenerator implements IdentifierGenerator, StandardGenerator, BeforeExecutionGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return UUID.randomUUID().toString();
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT);
    }
}
