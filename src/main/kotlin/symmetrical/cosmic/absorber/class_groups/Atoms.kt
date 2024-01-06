package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.atomic.atoms.states.booleans.QBoolean
import symmetrical.cosmic.physics.atomic.atoms.states.bytes.QByte
import symmetrical.cosmic.physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic.physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic.physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.physics.atomic.atoms.states.vectors.QMass

class Atoms : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), QBoolean::class))
        add(EntityId(Base52.classId(), QByte::class))
        add(EntityId(Base52.classId(), QDouble::class))
        add(EntityId(Base52.classId(), QInt::class))
        add(EntityId(Base52.classId(), QMass::class))
        add(EntityId(Base52.classId(), QString::class))

    }
}