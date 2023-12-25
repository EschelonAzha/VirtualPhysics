package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics.atomic.atoms.states.booleans.QBoolean
import symmetrical.cosmic._physics.atomic.atoms.states.bytes.QByte
import symmetrical.cosmic._physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic._physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.atoms.states.vectors.QMass

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