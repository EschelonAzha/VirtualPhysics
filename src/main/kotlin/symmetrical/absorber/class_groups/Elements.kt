package symmetrical.absorber.class_groups

import symmetrical.absorber.ClassGroup
import symmetrical.absorber.EntityId
import symmetrical.dictionary.protons.AccessLevelProton
import symmetrical.dictionary.protons.AliasNameProton
import symmetrical.dictionary.protons.FieldNameProton
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Element
import symmetrical.physics.atomic.atoms.elements.Helium
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.transpectors.printable_characters.Base52

class Elements : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), AccessLevelProton::class))
        add(EntityId().with(Base52.classId(), AliasNameProton::class))
        add(EntityId().with(Base52.classId(), FieldNameProton::class))
        add(EntityId().with(Base52.classId(), ValueProton::class))


        add(EntityId().with(Base52.classId(), Element::class))

        add(EntityId().with(Base52.classId(), Hydrogen::class))
        add(EntityId().with(Base52.classId(), Helium::class))
        add(EntityId().with(Base52.classId(), Lithium::class))
    }
}