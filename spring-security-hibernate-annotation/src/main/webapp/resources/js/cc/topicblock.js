(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['topicblock'] = template({"1":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div class=\"topic-block\" data-topic-id="
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "> \r\n	<div class=\"topic-header\">\r\n		<div>\r\n			<h4>\r\n				<span class=\"topic-header-text\" data-toggle=\"tooltip\" data-placement=\"top\" title=\""
    + alias4(((helper = (helper = helpers.header || (depth0 != null ? depth0.header : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"header","hash":{},"data":data}) : helper)))
    + "\">"
    + alias4(((helper = (helper = helpers.header || (depth0 != null ? depth0.header : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"header","hash":{},"data":data}) : helper)))
    + "</span>\r\n				<button class=\"btn btn-xs pull-right delete-topic\">\r\n					<span class=\"glyphicon glyphicon-trash\"></span>\r\n				</button>\r\n				<button class=\"btn btn-xs pull-right edit-topic\" data-toggle=\"modal\" data-target=\"#TOPIC_MODAL\">\r\n					<span class=\"glyphicon glyphicon-pencil\"></span>\r\n				</button>\r\n			</h4>\r\n		</div>\r\n	</div>\r\n\r\n	<div>\r\n\r\n"
    + ((stack1 = helpers.each.call(alias1,(depth0 != null ? depth0.slides : depth0),{"name":"each","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\r\n		<div class=\"add-new add-new-slide\">\r\n			<button class=\"btn btn-xs\" data-toggle=\"modal\" data-target=\"#SLIDE_MODAL\">\r\n				<span class=\"glyphicon glyphicon-plus\"></span>\r\n				Add slide \r\n			</button>\r\n		</div>\r\n	</div>\r\n</div>\r\n";
},"2":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = container.invokePartial(partials.sliderow,depth0,{"name":"sliderow","data":data,"indent":"\t\t","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "");
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "\r\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.topics : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"usePartial":true,"useData":true});
})();