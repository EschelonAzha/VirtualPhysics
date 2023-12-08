package symmetrical.cosmic._physics._subatomic.luminescent

import kotlin.reflect.KClass

class Matter : MatterAntiMatter {
    constructor(positive: KClass<*>, negative: KClass<*>) : super(positive, negative){

    }
}