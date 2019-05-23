package com.todoist.pojo

enum class Avatar constructor(private val size: Int, private val arg: String) {
    // In ascending order of size.
    SMALL(35, "small"),
    MEDIUM(60, "medium"),
    BIG(195, "big"),
    HUGE(640, "s640");

    fun getUrl(imageId: String?): String? {
        return if (imageId != null) {
            "https://dcff1xvirvpfp.cloudfront.net/" + imageId + "_" + getForSize(size).arg + ".jpg"
        } else {
            null
        }
    }

    companion object {
        /**
         * Returns the first [Avatar] to be larger than `size`. If none exist, returns the largest one.
         */
        @JvmStatic
        fun getForSize(size: Int): Avatar {
            val avatars = values()
            for (avatar in avatars) {
                if (avatar.size >= size) {
                    return avatar
                }
            }
            return avatars[avatars.size - 1]
        }

        /**
         * Returns an array of [Avatar] ordered by how optimal they are. The first should be the best, followed by
         * larger sizes and finally the smaller ones.
         */
        @JvmStatic
        fun getOrderedForSize(size: Int): Array<Avatar> {
            val avatars = values()
            val result = emptyArray<Avatar>()

            result[0] = getForSize(size)
            val bestOrdinal = result[0].ordinal

            for (i in 1 until result.size) {
                val prevOrdinal = result[i - 1].ordinal
                val ordinal: Int
                ordinal = if (prevOrdinal >= bestOrdinal) {
                    if (prevOrdinal < result.size - 1) {
                        prevOrdinal + 1
                    } else {
                        bestOrdinal - 1
                    }
                } else {
                    prevOrdinal - 1
                }

                result[i] = avatars[ordinal]
            }

            return result
        }
    }
}
