package symmetrical.cosmic.physics.subatomic.luminescent

import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Antimatter
 */
class AntiMatter : MatterAntiMatter, IAntiMatter {
    constructor(positive:KClass<*>, negative:KClass<*>) : super(positive, negative){

    }
}