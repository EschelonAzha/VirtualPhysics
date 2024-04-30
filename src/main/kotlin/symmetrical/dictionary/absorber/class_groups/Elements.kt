package symmetrical.dictionary.absorber.class_groups

import symmetrical.dictionary.absorber.ClassGroup
import symmetrical.dictionary.absorber.EntityId
import symmetrical.dictionary.protons.*
import symmetrical.physics.atomic.atoms.Element
import symmetrical.physics.atomic.atoms.elements.Helium
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.transpectors.printable_characters.Base52

class Elements : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), AccessLevelProton::class))
        add(EntityId().with(Base52.classId(), AliasNameProton::class))
        add(EntityId().with(Base52.classId(), CRUDProton::class))
        add(EntityId().with(Base52.classId(), FieldNameProton::class))
        add(EntityId().with(Base52.classId(), ValueProton::class))


        add(EntityId().with(Base52.classId(), Element::class))

        add(EntityId().with(Base52.classId(), Hydrogen::class))
        add(EntityId().with(Base52.classId(), Helium::class))
        add(EntityId().with(Base52.classId(), Lithium::class))
    }
}