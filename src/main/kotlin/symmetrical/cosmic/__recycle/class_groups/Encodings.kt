package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.*
import symmetrical.cosmic._bitmaps.*

class Encodings : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Base52::class))
        add(EntityId(Base52.classId(), Bits04::class))
        add(EntityId(Base52.classId(), Bits08::class))
        add(EntityId(Base52.classId(), Bits16::class))
        add(EntityId(Base52.classId(), Bits24::class))
        add(EntityId(Base52.classId(), Bits32::class))
        add(EntityId(Base52.classId(), Bits64::class))
        add(EntityId(Base52.classId(), Characters::class))
        add(EntityId(Base52.classId(), LowerCase::class))
        add(EntityId(Base52.classId(), Numbers::class))
        add(EntityId(Base52.classId(), UpperCase::class))
    }
}