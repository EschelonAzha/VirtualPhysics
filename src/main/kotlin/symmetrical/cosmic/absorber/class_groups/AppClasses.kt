package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.*
import symmetrical.cosmic.physics.subatomic.balanced.Monad
import symmetrical.cosmic.physics.atomic.substance.metals.Metal
import symmetrical.cosmic.chemistry.diatomics.KeyValue

class AppClasses : ClassGroup {
    constructor() {

        add(EntityId(Base52.classId(), KeyValue::class))
        add(EntityId(Base52.classId(), Metal::class))
        add(EntityId(Base52.classId(), Monad::class))

    }
}