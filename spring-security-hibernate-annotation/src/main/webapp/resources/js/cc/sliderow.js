(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['sliderow'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div data-slide-id=\""
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\" data-slide-type=\""
    + alias4(((helper = (helper = helpers.type || (depth0 != null ? depth0.type : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"type","hash":{},"data":data}) : helper)))
    + "\" class=\"topic-slide\"> \r\n	<span class=\"slide-header-text\">"
    + alias4(((helper = (helper = helpers.header || (depth0 != null ? depth0.header : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"header","hash":{},"data":data}) : helper)))
    + "</span>\r\n	<button class=\"delete-slide btn btn-xs pull-right\">\r\n		<span class=\"glyphicon glyphicon-trash\"></span>\r\n	</button>\r\n	<button class=\"update-slide btn btn-xs pull-right\" data-toggle=\"modal\" data-target=\"#SLIDE_MODAL\">\r\n		<span class=\"glyphicon glyphicon-pencil\"></span>\r\n	</button>\r\n</div>\r\n";
},"useData":true});
})();