package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.dictionary.protons.AccessLevelProton
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Element
import symmetrical.physics.atomic.atoms.elements.Helium
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.cosmic.transpectors.printable_characters.Base52

class Elements : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), ValueProton::class))
        add(EntityId().with(Base52.classId(), FieldNameProton::class))
        add(EntityId().with(Base52.classId(), AccessLevelProton::class))

        add(EntityId().with(Base52.classId(), symmetrical.physics.atomic.atoms.Element::class))

        add(EntityId().with(Base52.classId(), symmetrical.physics.atomic.atoms.elements.Hydrogen::class))
        add(EntityId().with(Base52.classId(), symmetrical.physics.atomic.atoms.elements.Helium::class))
        add(EntityId().with(Base52.classId(), symmetrical.physics.atomic.atoms.elements.Lithium::class))
    }
}