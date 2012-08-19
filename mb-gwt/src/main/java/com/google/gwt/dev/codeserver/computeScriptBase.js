function computeScriptBase() {
  // TODO(skybrian) This approach won't work for workers.

  $wnd.__gwt_activeModules['__MODULE_NAME__'].superdevmode = true;

  var expectedSuffix = '/__MODULE_NAME__.nocache.js';

  var scriptTags = $doc.getElementsByTagName('script');
  var ret = '';
  for (var i = 0;; i++) {
    var tag = scriptTags[i];
    if (!tag) {
      break;
    }
    var candidate = tag.src;
    var lastMatch = candidate.lastIndexOf(expectedSuffix);
    if (lastMatch > 0) {
      ret = candidate.substring(0, lastMatch + 1);
    }
  }
  if (ret) return ret;

  $wnd.alert('Unable to load Super Dev Mode version of ' + __MODULE_NAME__ + ".");
}
