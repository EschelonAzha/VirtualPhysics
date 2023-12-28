package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.dictionary.protons.ValueProton

class DictionaryGroup : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), ValueProton::class))
    }
}