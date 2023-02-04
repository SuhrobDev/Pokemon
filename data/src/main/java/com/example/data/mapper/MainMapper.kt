package com.example.data.mapper

import com.example.data.remote.dto.main.PokemonDto
import com.example.domain.model.PokemonModel
import com.example.domain.model.details.DetailsDto


fun PokemonDto.toModel(): PokemonModel {
    return PokemonModel(name = name, url = url)
}

fun com.example.data.remote.dto.details.DetailsDto.toData(): DetailsDto {
    return DetailsDto(id = id, name = name)
}
//
//fun GetForumByPagingDto.toModel(): GetForumByPagingModel {
//    return GetForumByPagingModel(total = total, data = data.map {
//        it.toModel()
//    })
//}
//
//fun PodcastCategoryDtoItem.toPodcastCategory(): PodcastCategories {
//    return PodcastCategories(
//        id = _id ?: "",
//        name = category.name,
//        podcasts = podcasts.map { it.toPodcast() },
//        categoryId = category._id
//    )
//}
//
//fun DataPagingDto.toModel(): DataPagingModel {
//    return DataPagingModel(
//        id = _id,
//        category.toModel(),
//        imgUrl,
//        replyCount,
//        student.toModel(),
//        text,
//        totalLikes,
//        isLiked,
//        isSaved = isSaved,
//        viewCount = viewCount
//    )
//}
//
//fun GetFaqDto.toModel(): GetFaqModel {
//    return GetFaqModel(_id, question, answer)
//}
//
//fun AboutDto.toModel(): AboutModel {
//    return AboutModel(_id, text)
//}
//
//fun GetDevicesDto.toModel(): GetDevicesModel {
//    return GetDevicesModel(_id, device, ip_address, studentId)
//}
//
//fun GetContactsDto.toModel(): GetContactsModel {
//    return GetContactsModel(_id, email, facebook, instagram, phoneNumber, telegram, tiktok, youtube)
//}
//
//fun CategoryPagingDto.toModel(): CategoryModel {
//    return CategoryModel(
//        _id, name
//    )
//}
//
//fun StudentPagingDto.toModel(): StudentModel {
//    return StudentModel(
//        _id, firstName, lastName, imgUrl
//    )
//}
//
///**  ---------------------------  Forum  ------------------------------------------  **/
//
//fun GetPostCommentsDto.toModel(): GetPostCommentsModel {
//    return GetPostCommentsModel(
//        _id,
//        comment,
//        likeCount,
//        student.toModel(),
//        createdAt = createdAt,
//        isSelected,
//        like,
//        dislike,
//        isSaved = isSaved
//    )
//}
//
//fun StudentPostDto.toModel(): StudentPostModel {
//    return StudentPostModel(
//        _id, firstName, imgUrl, lastName
//    )
//}
//
//fun PodcastDto.toPodcast(): Podcast {
//    return Podcast(
//        createdAt = createdAt, imgUrl = imgUrl, name = name, id = _id
//    )
//}
//
//fun PodcastDataDto.toPodcastData(): PodcastData {
//    return PodcastData(
//        id = _id, category = category, imgUrl = imgUrl, name = name, createdAt = createdAt
//    )
//}
//
////fun AudioDto.toAudio(): Audio {
////    return Audio(
////        _id = _id, audioUrl = audioUrl, imgUrl = imgUrl, name = name, duration = duration
////    )
////}
//
//fun PodcastInfoDto.toPodcastInfo(): PodcastInfo {
//    return PodcastInfo(
//        _id = _id, audio = audios.map {
//            it.toAudio()
//        }, imgUrl = imgUrl, name = name, description = description, isSaved = isSaved
//    )
//}
//
//fun AudioDto.toAudio(): Audio {
//    return Audio(
//        _id = _id, audioUrl = audioUrl, imgUrl = imgUrl, name = name, duration
//    )
//}
//
//
//fun VideoDataDto.toVideo(): VideoData {
//    return VideoData(
//        id = _id, imageUrl = imgUrl, title = name, category = category, link = link
//    )
//}
//
//fun NewsDataDto.toNews(): NewsData {
//    return NewsData(
//        id = _id,
//        imageUrl = imgUrl,
//        title = name,
//        category = category,
//        totalViews = totalViews,
//        createdAt = createdAt
//    )
//}
//
//fun AllCategoryDto.toModel(): AllCategoryModel {
//    return AllCategoryModel(
//        _id, name
//    )
//}
//
///**----------------------------------------SAVED----------------------------------------------------**/
//
//fun GetSavedDto.toModel(): GetSavedModel {
//    return GetSavedModel(
//        _id,
//        type,
//        isLiked = isLiked,
//        vocabulary = vocabulary?.toModel(),
//        podcast = podcast?.toModel(),
//        student = student?.toModel(),
//        forum = forum?.toModel(),
//        lesson = lessons?.map { it.toModel() }
//    )
//}
//
//fun ObjectSavedLessonDto.toData(): ObjectSavedLessonData {
//    return ObjectSavedLessonData(_id = _id, lessons = lessons.map { it.toModel() })
//}
//
//fun LessonSavedDto.toModel(): LessonData {
//    return LessonData(
//        _id = _id,
//        languageLevel = languageLevel,
//        lesson = lesson,
//        type = type
//    )
//}
//
//fun ForumSavedDto.toModel(): ForumSavedModel {
//    return ForumSavedModel(
//        id = _id,
//        imgUrl = imgUrl,
//        text = text,
//        totalLikes = totalLikes,
//        replyCount = replyCount,
//        viewCount = viewCount
//    )
//}
//
//fun PodcastSavedDto.toModel(): PodcastSavedModel {
//    return PodcastSavedModel(_id, createdAt, imgUrl, name)
//}
//
//fun SavedCountDto.toModel(): SavedCountModel {
//    return SavedCountModel(id = _id, count = count)
//}
//
//fun StudentDto.toModel(): uz.rounded.domain.model.main.saved.StudentModel {
//    return StudentModel(
//        id = _id,
//        firstName = firstName,
//        lastName = lastName,
//        imgUrl = imgUrl,
//        languageLevel = languageLevel
//    )
//}
//
//fun VocabularySavedDto.toModel(): VocabularySavedModel {
//    return VocabularySavedModel(
//        id = _id,
//        audioUrl = audioUrl,
//        transcript = transcript,
//        translation = translation,
//        word = word
//    )
//}
//
///**----------------------------------------SAVED----------------------------------------------------**/
//
//
//fun GetMyCoursesDto.toModel(): GetMyCoursesModel {
//    return GetMyCoursesModel(
//        _id,
//        courseId,
//        type,
//        status,
//        teacher,
//        percentage,
//        nextLesson?.toModel(),
//        currentLesson?.toModel()
//    )
//}
//
//fun CurrentLessonDto.toModel(): CurrentLessonModel {
//    return CurrentLessonModel(
//        lessonNumber, name
//    )
//}
//
//fun NextLessonDto.toModel(): NextLessonModel {
//    return NextLessonModel(
//        name, lessonNumber
//    )
//}
//
//fun EndTimeDto.toModel(): EndTimeModel {
//    return EndTimeModel(
//        hour, minute, _id
//    )
//}
//
//
//fun StartTimeDto.toModel(): StartTimeModel {
//    return StartTimeModel(
//        hour, minute, _id
//    )
//}
//
//
//fun SectionsDto.toSection(): SectionsModel {
//    return SectionsModel(
//        id = _id,
//        imgUrl = imgUrl,
//        name = name,
//        color = color,
//        labels = labels.map { it.toLabel() },
//        createdAt = createdAt,
//        description,
//        status
//    )
//}
//
//
//fun LabelDto.toLabel(): LabelModel {
//    return LabelModel(
//        imgUrl, name, _id
//    )
//}
//
///** --------------------------------Vocabuilary-------------------****/
//
//fun VocabularyDto.toModel(): VocabularyModel {
//    return VocabularyModel(
//        _id,
//        lessonId,
//        audioUrl,
//        imgUrl,
//        word,
//        translation,
//        transcript,
//        wordGroupId,
//        definition,
//        example,
//        otherWord1,
//        otherWord2,
//        wordGroup,
//        score,
//        isSaved
//    )
//}
//
//fun WordGroupDto.toWord(): WordGroupModel {
//    return WordGroupModel(
//        _id = _id, name = name, shortForm = shortForm
//    )
//}
//
///** --------------------------------LessonVidio-------------------****/
//
////fun LessonVidioDto.toModel(): LessonVidioModel {
////    return LessonVidioModel(
////        _id, videoUrl, title, description
////    )
////}
//
///** --------------------------------LessonVidio-------------------****/
//
//fun GrammerDto.toModel(): GrammerModel {
//    return GrammerModel(
//        _id = _id, content = content.map {
//            it.toDto()
//        }, score = score
//    )
//}
//
///** --------------------------------news-------------------****/
//
//fun NewsDto.toModel(): NewsModel {
//    return NewsModel(
//        _id, name, imgUrl, slug, content = content.map {
//            it.toDto()
//        }, totalViews
//    )
//}
//
//fun ContentDto.toDto(): ContentModel {
//    return ContentModel(
//        type = type, value = value, _id = _id
//    )
//}
//
//fun LessonVidioDto.toModel(): LessonVidioModel {
//    return LessonVidioModel(_id, videoUrl, title, description)
//}
//
//fun SpeakingDto.toModel(): SpeakingModel {
//    return SpeakingModel(_id, videoUrl, title, text, score)
//}
//
///**------------------------------------------------    PAYMENT    -------------------------------------------**/
//fun PaymentHistoryOutcomeDto.toModel(): PaymentHistoryOutcomeModel {
//    return PaymentHistoryOutcomeModel(id = _id, course = course.toData(), createdAt = createdAt)
//}
//
//fun CourseDto.toData(): CourseData {
//    return CourseData(name = name, price = price)
//}
//
//fun PaymentIncomeHistoryDto.toModel(): PaymentIncomeHistoryModel {
//    return PaymentIncomeHistoryModel(
//        id = _id,
//        createdAt = createdAt,
//        paymentType = paymentType,
//        status = status,
//        amount = amount
//    )
//}
///**------------------------------------------------    PAYMENT    -------------------------------------------**/

