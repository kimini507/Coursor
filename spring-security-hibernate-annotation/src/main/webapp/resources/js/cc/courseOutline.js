var CourseOutline = {};

CourseOutline.getTopic = function(val, attr){
  if(!CourseOutline.data || !CourseOutline.data.topics){
    return null;
  }
  
  attr = attr? attr:"id";
  
  for(var i = 0; i<CourseOutline.data.topics.length; i++){
    if(CourseOutline.data.topics[i][attr] == val){
      return CourseOutline.data.topics[i];
    }
  }
  
  return null;
}

CourseOutline.removeTopic = function(val, attr){
  if(!CourseOutline.data || !CourseOutline.data.topics){
    return false;
  }
  
  attr = attr? attr:"id";
  
  for(var i = 0; i<CourseOutline.data.topics.length; i++){
    if(CourseOutline.data.topics[i][attr] == val){
      delete CourseOutline.data.topics[i];
      CourseOutline.data.topics.splice(i,i+1);
      return true;
    }
  }
  
  return false;
}

CourseOutline.addTopic = function(data){
  CourseOutline.data.topics.push(data);
}

CourseOutline.getSlide = function(topic, slideId){
  for(var i = 0; i<topic.slides.length; i++){
    if(topic.slides[i].id == slideId){
      return topic.slides[i];
    }
  }
  return false;
}

CourseOutline.saveSlide = function(slide, topicId, slideId){
  var topic = this.getTopic(topicId, "id");
  var slideOld = this.getSlide(topic, slideId);
  slideOld.content = slide.content;
  console.log(slideOld);
}

CourseOutline.removeSlide = function(val, topicId, attr){
  attr = attr? attr:"id";
  var topic = this.getTopic(topicId, "id");
  
  for(var i = 0; i<topic.slides.length; i++){
    if(topic.slides[i] == val){
      delete topic.slide[i];
      topic.slides.splice(i,i+1);
      return true;
    }
  }
  
  return false;
}

