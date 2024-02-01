package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.cosmic.physics.atomic.atoms.elements.Helium
import symmetrical.cosmic.physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic.transpectors.printable_characters.Base52

class Elements : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), Hydrogen::class))
        add(EntityId().with(Base52.classId(), Helium::class))
    }
}