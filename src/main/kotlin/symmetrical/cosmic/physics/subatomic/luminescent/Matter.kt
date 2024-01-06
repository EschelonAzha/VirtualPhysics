package symmetrical.cosmic.physics.subatomic.luminescent

import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Matter
 */
class Matter : MatterAntiMatter, IMatter {
    constructor(positive: KClass<*>, negative: KClass<*>) : super(positive, negative){

    }
}