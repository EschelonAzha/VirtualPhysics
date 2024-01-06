package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.dictionary.protons.ValueProton

class DictionaryGroup : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), ValueProton::class))
    }
}